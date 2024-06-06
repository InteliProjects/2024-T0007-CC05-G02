import styled from "styled-components";

export const LeftBar = styled.div`
    width: 25%;
    height: 100%;
    background-color: #d9d9d9;

    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;

    input {
        width: 80%;
        height: 30px;
        margin-top: 15px;
        padding-left: 15px;

        border: none;
        border-radius: 15px;

        &::placeholder {
            color: #000;
        }
    }
`;

export const Labels = styled.div`
    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: flex-start;

    padding-left: 20px;
    padding-bottom: 20px;
`;

export const Label = styled.div`
    width: 100%;
    height: 40px;
    margin-top: 10px;

    display: flex;
    justify-content: flex-start;
    align-items: center;

    > div {
        height: 30px;
        width: 30px;
        display: flex;
        justify-content: center;
        align-items: center;

        border-radius: 50%;
        background-color: ${(props) => props.background};
    }

    > p {
        font-size: 15px;
        color: #000;
        margin-left: 10px;
    }
`;

export const ExecuteAlgorithm = styled.div`
    width: 100%;
    height: 50%;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    h2 {
        font-size: 20px;
        color: #000;
    }

    p {
        font-size: 15px;
        color: #000;
    }

    select {
        width: 80%;
        height: 30px;
        margin-top: 10px;
        padding-left: 15px;

        border: none;
        border-radius: 15px;

        &::placeholder {
            color: #000;
        }
    }

    button {
        width: 80%;
        height: 30px;
        margin-top: 10px;

        background-color: #0076b2;
        color: #fff;
        border: none;
        border-radius: 15px;

        cursor: pointer;
    }
`;
