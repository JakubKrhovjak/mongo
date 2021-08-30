import React, {useState} from "react";
import {Alert} from "../components/Alert";
import {getError} from "../utils/commonUtils";

export const DataContext = React.createContext();

export const DataContextProvider = ({children}) => {

    const [error, setError] = useState(null)

    return (
        <DataContext.Provider
            value={{setError}}
        >
            <>
                <Alert severity="error" message={getError(error)} show={!!error}/>
                {children}
            </>
        </DataContext.Provider>
    )

}

