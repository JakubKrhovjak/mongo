import React, {useEffect, useState} from "react";
import {makeStyles} from '@material-ui/core/styles';
import Grow from '@material-ui/core/Grow';
import {Alert as MuiAlert, AlertTitle} from "@material-ui/lab";
import Slide from "@material-ui/core/Slide";

const useStyles = makeStyles({
    root: {

        zIndex: "2000 !important",
        position: "absolute",
        opacity: "0.8 !important",
        width: "90%",
        marginTop: "5%"
    },
    // container: {
    //     display: "flex",
    //     justifyContent: "center",
    //     alignItems: "center",
    // }

});

export const Alert = ({show, message, ...rest}) => {
    const classes = useStyles();

    const [state, setState] = useState({show});

    useEffect(() => {
        setState({show})
    }, [show])

    return (
        state.show &&

            <Slide id="alert" in={show} timeout={1000} className={classes.root} onClick={() => setState({show: false})}>
                <MuiAlert {...rest} className={classes.root}>
                    <AlertTitle>Error</AlertTitle>
                    {message}
                </MuiAlert>
            </Slide>


    )

}
