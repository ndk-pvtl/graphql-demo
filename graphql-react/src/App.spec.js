import React from 'react';
import App from './App';
import {MockedProvider} from 'react-apollo/test-utils';
import {greetQuery} from "./queries";
import {mount} from "enzyme";
import * as ReactDOM from "react-dom";

jest.useFakeTimers();

describe(`App`, () => {

    let element;
    let appWrapper;
    const mocks = [
            {
                request: {
                    query: greetQuery,
                },
                result: {
                    data: {
                        greet: {
                            message: 'Hi there,',
                            name: 'testUser'
                        }
                    }
                }

            }
        ];


    beforeEach(() => {
        element = document.createElement('div');

        appWrapper = mount(
            <MockedProvider mocks={mocks} addTypename={false}>
                <App/>
            </MockedProvider>, element);

    });
    afterEach(() => {
        ReactDOM.unmountComponentAtNode(element);
    });

    it(`should render the corresponding message while data is loading`, () => {

        expect(appWrapper.text()).toEqual('Loading...');

    });

    it(`should render the greeting message when data has been fetched`, () => {
        jest.runAllTimers();

        appWrapper.update();

        expect(appWrapper.text()).toEqual('Hi there, testUser!');
    });

});
