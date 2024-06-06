import React from "react";
import { LeftBar, Labels, Label, ExecuteAlgorithm } from "./style";
import { nodesInfo } from "../../constants/nodesInfo";

function Sidebar() {
    return (
        <LeftBar>
            <ExecuteAlgorithm>
                <h2>Executar Algoritmo</h2>
                <p>Selecione o algoritmo que deseja executar:</p>
                <select>
                    <option value="1">Edmonds-Karp</option>
                    <option value="2">Ford-Fulkerson</option>
                </select>
                <button>Executar</button>
            </ExecuteAlgorithm>
            <Labels>
                {nodesInfo.map((item, index) => {
                    return (
                        <Label key={index} background={item.color}>
                            <div>{item.abbreviation}</div>
                            <p>{item.label}</p>
                        </Label>
                    );
                })}
            </Labels>
        </LeftBar>
    );
}

export default Sidebar;
