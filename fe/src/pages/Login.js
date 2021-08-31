import React, {useState} from "react";
import PropTypes from 'prop-types';
import {httpService} from "../httpClient";
import {Formik} from "formik";


export const Login = ({setToken}) => {

    function loginUser(credentials) {
        httpService.post("/token", credentials, data => {
              setToken({token: data.data, error: data.error})
            }
        )

    }
    //
    // function loginUser(credentials) {
    //     httpClient.post("/token", credentials)
    //         .then(r => {
    //             console.log(r);
    //         })
    //         .catch(e => {
    //             console.error(e);
    //         })
    //
    // }

    return (
        <>
            <h1>Please Log In</h1>
            <Formik
                initialValues={{username: '', password: ''}}
                onSubmit={(values, {setSubmitting}) => {
                    loginUser(values)
                    setSubmitting(false);
                }}

            >
                {({
                      values,
                      errors,
                      touched,
                      handleChange,
                      handleBlur,
                      handleSubmit,
                      isSubmitting,
                      /* and other goodies */
                  }) => (
                    <form onSubmit={handleSubmit}>
                        <label>
                            <p>Username</p>
                            <input
                                type="username"
                                name="username"
                                onChange={handleChange}
                                onBlur={handleBlur}
                                value={values.email}
                            />
                        </label>
                        {errors.username && touched.username && errors.username}
                        <input
                            type="password"
                            name="password"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.password}
                        />
                        {errors.password && touched.password && errors.password}
                        <div>
                            <button type="submit" disabled={isSubmitting}>
                                Submit
                            </button>
                        </div>
                    </form>
                )}
            </Formik>
        </>
    );
}

Login.propTypes =
    {
        setToken: PropTypes.func.isRequired
    }