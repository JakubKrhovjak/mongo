import React, {useEffect, useState} from "react";
import {makeStyles} from '@material-ui/core/styles';
import {Alert as MuiAlert, AlertTitle} from "@material-ui/lab";
import Slide from "@material-ui/core/Slide";
import Grid from "@material-ui/core/Grid";

const useStyles = makeStyles({
        root: {

            zIndex: "2000 !important",
            position: "absolute",
            opacity: "0.8 !important",
            width: "90%",
            marginTop: "5%"
        },
    })
;

export const Alert = ({show, message, ...rest}) => {
    const classes = useStyles();

    const [state, setState] = useState({show});

    useEffect(() => {
        setState({show})
    }, [show])

    return (
        state.show &&
        <Grid container justify="center">
            <Slide in={show} timeout={1000} className={classes.root} onClick={() => setState({show: false})}>
                <MuiAlert {...rest} className={classes.root}>
                    <AlertTitle>Error</AlertTitle>
                    {message}
                </MuiAlert>
            </Slide>
        </Grid>


    )

}
