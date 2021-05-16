import React, {useEffect} from 'react';
import ReactDOM from 'react-dom';
import Button from '@material-ui/core/Button';
import { httpClient } from "./httpClient";


const HelloWorld = () => {

    useEffect(() => {
        httpClient.get("/mongo")
            .then(res => console.log(res.data))
            .catch(e => console.log(e))
    }, [])

    return (
        <Button variant="contained" color="primary">
            Hello World
        </Button>
    );
}

ReactDOM.render(<HelloWorld/>, document.getElementById("root"));