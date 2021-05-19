import React, {useEffect, useState} from "react";
import {DataGrid} from "@material-ui/data-grid";
import {httpClient} from "../httpClient";


export const Items = (props) => {

    const [state, setState] = useState({items: []})

    useEffect(() => {
        httpClient.get("/mongo")
            .then(res => {
                setState({items: res.data.content})
            })
            .catch(e => console.log(e))
    }, [])


    const columns = [
        {field: "id", hide:true},
        {field: "name", headerName: "Name", width: 150},
        {field: "description", headerName: "Description", width: 150},
        {field: "status", headerName: "Status", width: 150},

    ];


    return (
        <div style={{height: "100%", width: "100%"}}>
            <DataGrid rows={state.items} columns={columns}/>
        </div>
    );


}