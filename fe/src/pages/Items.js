import React, { useState, useContext} from "react";
import {httpService} from "../httpClient";
import {Table} from "../components/Table";
import {AlertContext} from "../context/AlertContext";


const columns = [
    {field: "id", hide: true},
    {field: "name", headerName: "Name", width: 150},
    {field: "description", headerName: "Description", width: 150},
    {field: "status", headerName: "Status", width: 150},

];

export const Items = (props) => {
    const { setError } = useContext(AlertContext);
    const [state, setState] = useState({page: {content: []}, error: null})

    // useEffect(() => {
    //     let eventSource = new EventSource("http://localhost:8080/event")
    //     eventSource.onmessage = e => {
    //         console.log("Message: ", e)
    //     }
    //     eventSource.onerror = e => {
    //         console.log("error: ", e)
    //     }
    //
    //     eventSource.onopen = e => {
    //         console.log("onopen: ", e)
    //     }
    // }, [])

    const fetItems = (tableState) => {
        httpService.page("/mongo", tableState, data => {
                setState(data)
                setError(data)
            }
        )
    }

    return (
        <div style={{height: "100%", width: "100%"}}>
            <Table columns={columns}
                   page={state.page}
                   fetch={fetItems}/>
        </div>
    );


}