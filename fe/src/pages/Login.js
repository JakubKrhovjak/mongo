import React, {useState} from "react";
import PropTypes from 'prop-types';


export const Login = ({setToken}) => {

    const [credential, setCredential] = useState({username: null, password: null});

    return (
        <>
            <h1>Please Log In</h1>
            <form>
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