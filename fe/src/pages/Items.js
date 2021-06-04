import React, {useState} from "react";
import {httpService} from "../httpClient";
import {Table} from "../components/Table";
import {Alert} from "../components/Alert";
import {getError} from "../utils/commonUtils";


const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {

    const [state, setState] = useState({page: {content: []}, error: null})

    const fetItems = (tableState) => {
        httpService.page("/mongo", tableState, data => {
                setState(data)
            }
        )
    }


    return (
        <div style={{height: "100%", width: "100%"}}>
          <Alert severity="error"  message={getError(state.error)} show={state.error} />
            <Table columns={columns}
                   data={state.page.content}
                   fetch={fetItems}/>
        </div>
    );


}