import axios from "axios";

const httpClient = axios.create({
    baseURL: 'http://localhost:8080'
});

export const httpService = {

    post: (url, data, action) => {
         httpClient.post(url, data)
             .then(res => {
                  action({data: res.data, error: null})
             })
             .catch(e => {
                 action({data: null, error: e?.response?.data?.error})
             })
     },

    page: (url, data, action) => {
        httpClient.post(url, data)
            .then(res => {
                action({page: res.data, error: null})
            })
            .catch(e => {
                action({page: {content: []}, error: e?.response?.data?.error})
            })
    }
}
