import React, {useState} from "react";
import {Items} from "./pages/Items";
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import {Login} from "./pages/Login";
import {DataContextProvider} from "./context/DataContext";

export const App = () => {
    const [state, setState] = useState({token: null, error: null});

    if (!state?.token) {
        return <Login setToken={setState}/>
    }

    return (
        <DataContextProvider>
            <BrowserRouter>
                <Switch>
                    <Route exact path='/items'>
                        <Items/>
                    </Route>
                    <Route path='/'>
                        <Login setToken={setState}/>
                    </Route>
                </Switch>
            </BrowserRouter>
        </DataContextProvider>

    );
}
