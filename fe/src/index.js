import React from 'react';
import ReactDOM from 'react-dom';
import {Items} from "./pages/Items";
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import {Login} from "./pages/Login";

const Index = () => {
    const [token, setToken] = useState();

    if(!token) {
        return <Login setToken={setToken} />
    }


    return (
        <BrowserRouter>
            <Switch>
                <Route exact path='/items'>
                    <Items/>
                </Route>
                <Route path='/'>
                    <Login/>
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

ReactDOM.render(<Index/>, document.getElementById("root"));