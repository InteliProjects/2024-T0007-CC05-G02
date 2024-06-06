import "./styles/reset.css";
import "./styles/fonts/inter.css";
import { RouterProvider } from "react-router-dom";
import AppRoutes from "./routes/router";
import Modal from "react-modal"

Modal.setAppElement("#root")

function App() {
  return <RouterProvider router={AppRoutes} />;
}

export default App;
