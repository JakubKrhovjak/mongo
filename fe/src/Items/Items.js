import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";
import {httpClient} from "../httpClient";

export const DEFAULT_STATE = {items: [], page: 0, pageSize: 30}

export const Items = (props) => {

    const [state, setState] = useState(DEFAULT_STATE)

    useEffect(() => {
        httpClient.post("/mongo", state)
            .then(res => {
                setState({...state, items: res.data.content})
            })
            .catch(e => console.log(e))
    }, [])


    const columns = [
        {field: "id", hide: true},
        {field: "name", headerName: "Name", width: 150},
        {field: "description", headerName: "Description", width: 150},
        {field: "status", headerName: "Status", width: 150},

    ];

    const handleFilterModelChange = (model) => {
        const filters = model.filterModel.items;
       const a = filters.find(f => f.value);
        a && httpClient.post("/mongo", {
            filters: filters,
            page: state.page,
            pageSize: state.pageSize
        })
            .then(res => {
                setState({...state, items: res.data.content})
            })


    }

    return (
        <div style={{height: "100%", width: "100%"}}>
            <DataGrid rows={state.items} columns={columns}
                      filterMode="server"
                      onFilterModelChange={handleFilterModelChange}
                // filterModel={{
                //     items: [
                //         {columnField: "name", operatorValue: "contains", value: ''},
                //     ],
                // }}
            />
        </div>
    );


}