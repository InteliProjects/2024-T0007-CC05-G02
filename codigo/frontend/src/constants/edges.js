import axios from "axios";

export async function fetchEdges() {
    return await axios.get("http://localhost:8081/arestas");
}

export const initialEdges = [
    { id: "e1-4", source: "1", target: "4", capacity: 10, flow: 0 },
    { id: "e2-4", source: "2", target: "4", capacity: 10, flow: 0 },
    { id: "e2-5", source: "2", target: "5", capacity: 10, flow: 0 },
    { id: "e3-5", source: "3", target: "5", capacity: 10, flow: 0 },
    { id: "e3-6", source: "3", target: "6", capacity: 10, flow: 0 },
    { id: "e4-7", source: "4", target: "7", capacity: 10, flow: 0 },
    { id: "e4-8", source: "4", target: "8", capacity: 10, flow: 0 },
    { id: "e5-8", source: "5", target: "8", capacity: 10, flow: 0 },
    { id: "e5-9", source: "5", target: "9", capacity: 10, flow: 0 },
    { id: "e5-10", source: "5", target: "10", capacity: 10, flow: 0 },
    { id: "e6-10", source: "6", target: "10", capacity: 10, flow: 0 },
    { id: "e7-12", source: "7", target: "12", capacity: 10, flow: 0 },
    { id: "e8-11", source: "8", target: "11", capacity: 10, flow: 0 },
    { id: "e9-12", source: "9", target: "12", capacity: 10, flow: 0 },
    { id: "e10-12", source: "10", target: "12", capacity: 10, flow: 0 },
].map((edge) => ({
    ...edge,
    label: `${edge.flow}/${edge.capacity}`,
}));
