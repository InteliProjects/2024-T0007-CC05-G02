export function CreateNodesCoordinatesColumns(nodes) {
  console.log("Tamanho: ", nodes.length);

  const modifiedNodes = nodes;
  const COLUMNS_SIZE = 12;
  let lastXCoordinate = 25;
  let lastYCoordinate = 25;

  const columns = {
    cliente: {
      amount: 0,
      columns: [[]],
    },
    fornecedor: {
      amount: 0,
      columns: [[]],
    },
    patio: {
      amount: 0,
      columns: [[]],
    },
    pontoCargaDescarga: {
      amount: 0,
      columns: [[]],
    },
    usinaBeneficiamento: {
      amount: 0,
      columns: [[]],
    },
    usinaBriquetes: {
      amount: 0,
      columns: [[]],
    },
    usinaPelotizacao: {
      amount: 0,
      columns: [[]],
    },
    porto: {
      amount: 0,
      columns: [[]],
    },
  };

  const nodesInfo = {
    cliente: {
      coordinate: [1225, 0],
      amount: 0,
      height: 0,
    },
    fornecedor: {
      coordinate: [925, 0],
      amount: 0,
      height: 0,
    },
    patio: {
      coordinate: [325, 0],
      amount: 0,
      height: 0,
    },
    pontoCargaDescarga: {
      coordinate: [625, 0],
      amount: 0,
      height: 0,
    },
    usinaBeneficiamento: {
      coordinate: [25, -75],
      amount: 0,
      height: 0,
    },
    usinaBriquetes: {
      coordinate: [2125, 0],
      amount: 0,
      height: 0,
    },
    usinaPelotizacao: {
      coordinate: [1525, 0],
      amount: 0,
      height: 0,
    },
    porto: {
      coordinate: [1825, 0],
      amount: 0,
      height: 0,
    },
  };

  for (let i = 0; i < modifiedNodes.length; i++) {
    const currentNode = modifiedNodes[i].tipoElo.toLowerCase();

    const nodeTypeToPropertyMap = {
      ub: "usinaBeneficiamento",
      pa: "patio",
      pt: "pontoCargaDescarga",
      cl: "cliente",
      fo: "fornecedor",
      br: "usinaBriquetes",
      up: "usinaPelotizacao",
      po: "porto",
    };

    const nodeInfoKey = nodeTypeToPropertyMap[currentNode];

    if (nodeInfoKey) {
      const tamanho = columns[nodeInfoKey].columns.length;

      if (columns[nodeInfoKey].amount < COLUMNS_SIZE) {
        columns[nodeInfoKey].amount++;
        columns[nodeInfoKey].columns[tamanho - 1].push(nodes[i]);
      } else {
        columns[nodeInfoKey].columns.push([nodes[i]]);
      }
    }
  }

  const novosNodes = [];

  for (const tipo in columns) {
    for (const coluna of columns[tipo].columns) {
      for (const node of coluna) {
        if (columns[tipo].amount < COLUMNS_SIZE) {
          novosNodes.push({
            ...node,
            position: { x: lastXCoordinate, y: lastYCoordinate },
          });
          lastYCoordinate += 100;
        } else {
          columns[tipo].amount = 0;
          lastYCoordinate = 25;
          lastXCoordinate += 300;
          novosNodes.push({
            ...node,
            position: { x: lastXCoordinate, y: lastYCoordinate },
          });
        }
        //console.log(lastXCoordinate, lastYCoordinate);
        columns[tipo].amount++;
      }
    }
  }

  return novosNodes;
}
