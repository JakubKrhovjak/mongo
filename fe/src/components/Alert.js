import React from "react";
import {makeStyles} from '@material-ui/core/styles';
import {Alert as MuiAlert, AlertTitle} from "@material-ui/lab";

const useStyles = makeStyles({
    root: {

        zIndex: "2000 !important",
        position: "absolute",
        opacity: "0.8",
        width: "100%",
    }
});

export const Alert = ({show, message, ...rest}) => {
    const classes = useStyles();
    return (
        show && <MuiAlert {...rest} className={classes.root}>
            <AlertTitle>Error</AlertTitle>
            {message}
        </MuiAlert>
    )

}
