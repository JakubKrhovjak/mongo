import React, {useContext} from "react";
import {httpService} from "../httpClient";
import {Table} from "../components/Table";
import {DataContext} from "../context/DataContext";


const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {
    const {setState, page} = useContext(DataContext);

    const fetItems = (tableState) => {
        httpService.page("/mongo", tableState, data => {
                setState(data)
            }
        )
    }

    return (
        <div style={{height: "100%", width: "100%"}}>
            <Table columns={columns}
                   page={page}
                   fetch={fetItems}/>
        </div>
    );


}