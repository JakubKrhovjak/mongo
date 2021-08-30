import React, {useContext, useState} from "react";
import {DataContext} from "../context/DataContext";
import {httpService} from "../httpClient";

const INIT_STATE = {content: []};

export const useFetchPage = (url) => {
    const {setError} = useContext(DataContext);

    const [page, setPage] = useState(INIT_STATE)

    const fetchPage = tableState => {
        httpService.page(url, tableState, data => {
                setPage(data.page)
                setError(data.error)
            }
        )
    };

    return {page, fetchPage};
};
