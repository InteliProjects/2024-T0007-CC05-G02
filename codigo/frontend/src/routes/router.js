import { createBrowserRouter } from "react-router-dom";
import GraphViewer from "../pages/GraphViewer";

const AppRoutes = createBrowserRouter([
  {
    path: "/",
    element: <GraphViewer />,
  },
]);

export default AppRoutes;
