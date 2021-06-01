import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";
import {httpClient} from "../httpClient";

export const DEFAULT_REQUEST = {items: [], page: 1, pageSize: 1 }

export const Items = (props) => {

    const [state, setState] = useState({items: []})

    useEffect(() => {
        httpClient.post("/mongo", DEFAULT_REQUEST)
            .then(res => {
                setState({items: res.data.content})
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
        httpClient.post("/mongo", model.filterModel)
            .then(res => {
                setState({items: res.data.content})
            })
            .catch(e => console.log(e))

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