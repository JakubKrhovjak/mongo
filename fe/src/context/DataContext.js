import React, {useState} from "react";
import {Alert} from "../components/Alert";
import {getError} from "../utils/commonUtils";

export const DataContext = React.createContext();

export const DataContextProvider = ({children}) => {

    const [state, setState] = useState({page: {content: []}, error: null})

    return (
        <DataContext.Provider
            value={{setState, page: state.page}}
        >
            <>
                <Alert severity="error" message={getError(state.error)} show={!!state.error}/>
                {children}
            </>
        </DataContext.Provider>
    )

}

