import React, {useContext, useMemo} from "react";
import {httpService} from "../httpClient";
import {Table} from "../components/Table";
import {DataContext} from "../context/DataContext";
import {useFetchPage} from "../hooks/useFetchPage";


const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {
    const { fetchPage, page }= useFetchPage("/mongo");

    return (
        <div style={{height: "100%", width: "100%"}}>
            <Table columns={columns}
                   page={page}
                   fetch={fetchPage}/>
        </div>
    );


}