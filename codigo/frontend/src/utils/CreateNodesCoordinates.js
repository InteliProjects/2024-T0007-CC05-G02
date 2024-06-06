export function CreateNodesCoordinates(nodes) {
  const modifiedNodes = nodes;

  const dimensoes = 50;
  const verticalDistance = 100;
  let lastX = 25;

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

  for (let i = 0; i < nodes.length; i++) {
    const currentNode = nodes[i].tipoElo.toLowerCase();

    switch (currentNode) {
      case "ub":
        nodesInfo.usinaBeneficiamento.amount++;
        break;
      case "cl":
        nodesInfo.cliente.amount++;
        break;
      case "fo":
        nodesInfo.fornecedor.amount++;
        break;
      case "pa":
        nodesInfo.patio.amount++;
        break;
      case "pt":
        nodesInfo.pontoCargaDescarga.amount++;
        break;
      case "br":
        nodesInfo.usinaBriquetes.amount++;
        break;
      case "up":
        nodesInfo.usinaPelotizacao.amount++;
        break;
      case "po":
        nodesInfo.porto.amount++;
        break;
    }
  }

  let maxValue = { key: null, value: { amount: -Infinity } };

  for (const [key, value] of Object.entries(nodesInfo)) {
    if (value.amount > maxValue.value.amount) {
      maxValue = { key, value };
    }
  }

  const maxHeight =
    dimensoes * maxValue.value.amount +
    (verticalDistance / 2) * (maxValue.value.amount - 1);

  for (let node in nodesInfo) {
    nodesInfo[node].height =
      dimensoes * nodesInfo[node].amount +
      (verticalDistance / 2) * (nodesInfo[node].amount - 1);

    nodesInfo[node].coordinate[1] =
      (maxHeight - nodesInfo[node].height) / 2 + 25;
  }

  for (let i = 0; i < modifiedNodes.length; i++) {
    const currentNode = nodes[i].tipoElo.toLowerCase();

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
      //   let x = lastX;
      //   let y = nodesInfo[nodeInfoKey].coordinate[1] + 100;

      //   lastX += 10;

      let x = nodesInfo[nodeInfoKey].coordinate[0];
      let y = nodesInfo[nodeInfoKey].coordinate[1] + 100;

      lastX += 10;

      nodesInfo[nodeInfoKey].coordinate = [x, y];

      modifiedNodes[i].position = { x, y };
    }
  }

  // console.log(modifiedNodes);

  modifiedNodes.map((item) => ({
    ...item,
    type: "simpleBezier",
    sourcePosition: "right",
    targetPosition: "left",
  }));

  return modifiedNodes;
}

let objeto = {
  id: "1",
  data: {},
  position: {
    x: 114.57058823529411,
    y: 149.28676470588235,
  },
  style: {
    width: "75px",
    height: "75px",
    borderRadius: "50%",
    background: "#0076b2",
  },
  width: 30,
  height: 30,
  selected: false,
  positionAbsolute: {
    x: 114.57058823529411,
    y: 149.28676470588235,
  },
  draggable: true,
  sourcePosition: "right",
  targetPosition: "left",
};
