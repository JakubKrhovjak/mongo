import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";

export const DEFAULT_STATE = {filters: [], page: 0, pageSize: 30, sort: {}}

export const Table = ({columns, data, fetch}) => {

    const [state, setState] = useState(DEFAULT_STATE)

    useEffect(() => {
        fetch(state);
    }, [state])

    const handleFilterModelChange = (event) => {
        const filters = event.filterModel.items;
        filters.find(f => f.value) && setState({...state, filters})
    }

    const onSortModelChange = (event) => {
        setState({...state, sort: {...event.sortModel, direction: event.sortModel.sort}})
    }

    return (
        <div style={{height: "100%", width: "100%"}}>
            <DataGrid rows={data}
                      columns={columns}
                      filterMode="server"
                      onFilterModelChange={handleFilterModelChange}
                      onSortModelChange={onSortModelChange}
            />
        </div>
    );

}