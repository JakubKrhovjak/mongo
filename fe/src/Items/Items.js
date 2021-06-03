import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";
import {httpClient} from "../httpClient";

export const DEFAULT_STATE = {items: [], filters: [], page: 0, pageSize: 30, sort: {}}


const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {

    const [state, setState] = useState(DEFAULT_STATE)

    useEffect(() => {
        fetItems();
    }, [state])

    const fetItems = () => {
        httpClient.post("/mongo", state)
            .then(res => {
                setState({...state, items: res.data.content})
            })
            .catch(e => console.log(e))
    }

    const handleFilterModelChange = (event) => {
        const filters = event.filterModel.items;
        filters.find(f => f.value) && setState({...state, filters})
    }

    const onSortModelChange = (event) => {
        setState({...state, sort: {...event.sortModel, direction:  event.sortModel.sort}})
    }

    return (
        <div style={{height: "100%", width: "100%"}}>
            <DataGrid rows={state.items} columns={columns}
                      filterMode="server"
                      onFilterModelChange={handleFilterModelChange}
                      onSortModelChange={onSortModelChange}
                // filterModel={{
                //     items: [
                //         {columnField: "name", operatorValue: "contains", value: ''},
                //     ],
                // }}
            />
        </div>
    );


}