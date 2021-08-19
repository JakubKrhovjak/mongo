import React, {useState} from "react";
import {Alert} from "../components/Alert";
import {getError} from "../utils/commonUtils";

export const AlertContext = React.createContext();

export const AlertContextProvider = ({children}) => {

    const [error, setError] = useState(undefined)

    return (
        <AlertContext.Provider
            value={{setError}}
        >
            <>
                <Alert severity="error" message={getError(error)} show={!!error}/>
                {children}
            </>
        </AlertContext.Provider>
    )

}

