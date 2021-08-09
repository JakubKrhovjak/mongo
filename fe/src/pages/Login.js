import React, {useState} from "react";
import PropTypes from 'prop-types';
import {httpService} from "../httpClient";


export const Login = ({setToken}) => {

    const [credential, setCredential] = useState({username: null, password: null});


    function loginUser(credentials) {
        httpService.post("/token", credentials, data => {
              setToken(data)
            }
        )

    }

    return (
        <>
            <h1>Please Log In</h1>
            <form onSubmit={() => loginUser(credential)}>
                <label>
                    <p>Username</p>
                    <input type="text" onChange={e => setCredential({...credential, username: e.target.value})}/>
                </label>
                <label>
                    <p>Password</p>
                    <input type="password" onChange={e => setCredential({...credential, password: e.target.value})}/>
                </label>
                <div>
                    <button type="submit">Submit</button>
                </div>
            </form>
        </>
    );
}

Login.propTypes = {
    setToken: PropTypes.func.isRequired
}