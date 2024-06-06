import { useEffect, useState } from "react";
import React, { useCallback } from "react";
import ReactFlow, {
  addEdge,
  MiniMap,
  Controls,
  Background,
  useNodesState,
  useEdgesState,
} from "reactflow";
import "reactflow/dist/style.css";

import { Container } from "./style";
import { CreateNodesCoordinates } from "../../utils/CreateNodesCoordinates";
import { CreateNodesCoordinatesColumns } from "../../utils/CreateNodesCoordinatesColumns";
import { initialNodes, fetchNodes } from "../../constants/nodes";
import { fetchEdges } from "../../constants/edges";
import { nodesInfo } from "../../constants/nodesInfo";

export default function GraphContainer() {
  const [nodes, setNodes, onNodesChange] = useNodesState([]);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);

  useEffect(() => {
    fetchNodes().then((res) => {
      const nodes = res.data.map((node) => {
        return {
          id: `${node.id}`,
          tipoElo: node.tipoElo,
          data: node.data,
          style: {
            borderRadius: "50%",
            background: "#0076b2",
          },
          width: 30,
          height: 30,
          selected: false,
          draggable: true,
          sourcePosition: "right",
          targetPosition: "left",
        };
      });

      const modificados = CreateNodesCoordinatesColumns(nodes);
      console.log(modificados);
      //console.log(CreateNodesCoordinates(nodes));
      //console.log(CreateNodesCoordinatesColumns("colunas", nodes));

      setNodes(() => {
        return modificados.map((node) => {
          return {
            ...node,
            style: {
              width: "40px",
              height: "40px",
              borderRadius: "50%",
              background: nodesInfo.find(
                (info) =>
                  info.abbreviation.toLowerCase() === node.tipoElo.toLowerCase()
              ).color,
            },
          };
        });
      });
    });

    fetchEdges().then((res) => {
      const edges = res.data.map((edge) => {
        return {
          id: `${edge.id}`,
          source: `${edge.idEloCadeiaProducaoOrigem}`,
          target: `${edge.idEloCadeiaProducaoDestino}`,
          capacity: edge.pesoMedio,
          flow: edge.fluxoUtilizado,
          label: `${edge.fluxoUtilizado}/${edge.pesoMedio}`,
          type: "simpleBezier",
        };
      });

      setEdges(() => {
        return edges.map((edge) => {
          return {
            ...edge,
            style: { stroke: getEdgeColor() },
          };
        });
      });
    });
  }, []);

  function handleNodeClick(event, node) {
    if (node.id === "11" || node.id === "12") {
      // setClickedNode((prevClickedNode) =>
      //     prevClickedNode === node.id ? null : node.id
      // );
    }
  }

  function getEdgeColor() {
    return "#d3d3d3";
  }

  function returnReactFlow() {
    return (
      <ReactFlow
        nodes={nodes}
        edges={edges}
        onNodeClick={handleNodeClick}
        proOptions={{ hideAttribution: true }}
        panOnDrag={true}
        fitView
      >
        <Background color="#888" gap={16} />
      </ReactFlow>
    );
  }

  return (
    <Container>
      {nodes.length > 0 ? returnReactFlow() : <h1>Loading...</h1>}
    </Container>
  );
}
