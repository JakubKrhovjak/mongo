import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";

export const DEFAULT_STATE = {filters: [], page: 0, pageSize: 30, sort: {}}

export const Table = ({columns, page, fetch}) => {

    const [state, setState] = useState(DEFAULT_STATE)

    useEffect(() => {
        fetch(state);
    }, [state])

    const handleFilterModelChange = (event) => {
        const filters = event.filterModel.items;
        filters.find(f => f.value) && setState({...state, filters, page : 0})
    }

    const onSortModelChange = (event) => {
        setState({...state, sort: {...event.sortModel, direction: event.sortModel.sort}})
    }

    const onPageChange = (pageSettings) => {
        setState({...state, page: pageSettings.page })
    }

    const onPageSizeChange = (pageSettings) => {
        setState({...state, pageSize: pageSettings.pageSize, page: 0 })
    }


    return (
        <div style={{height: "100%", width: "100%"}}>
            <DataGrid rows={page.content}
                      pagination
                      page={page.number}
                      pageSize={page.size}
                      rowCount={page.totalElements}
                      onPageChange={onPageChange}
                      onPageSizeChange={onPageSizeChange}
                      rowsPerPageOptions={[1, 2, 100]}
                      paginationMode="server"
                      columns={columns}
                      filterMode="server"
                      onFilterModelChange={handleFilterModelChange}
                      onSortModelChange={onSortModelChange}
            />
        </div>
    );

}