import React from 'react';
import './App.css';
import {Query} from "react-apollo";
import {greetQuery} from "./queries";

const App = () => (
    <Query query={greetQuery}>
        {({loading, error, data}) => {
            if (loading) return "Loading...";
            if (error) return "Cannot fetch data.";
            return `${data.greet.message} ${data.greet.name}!`
        }}
    </Query>
);

export default App;
