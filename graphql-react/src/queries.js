import {gql} from "apollo-boost";

export const greetQuery = gql`
    {
        greet(name: "Yolo") {
            message
            name
        }
    }`;