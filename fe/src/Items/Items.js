import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";
import {httpClient} from "../httpClient";
import {Table} from "./components/Table";



const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {

    const [state, setState] = useState({items: []})

    const fetItems = (tableState) => {
        httpClient.post("/mongo", tableState)
            .then(res => {
                setState({...state, items: res.data.content})
            })
            .catch(e => console.log(e))
    }



    return (
        <div style={{height: "100%", width: "100%"}}>
                <Table columns={columns}
                       data={state.items}
                       fetch={fetItems} />
        </div>
    );


}