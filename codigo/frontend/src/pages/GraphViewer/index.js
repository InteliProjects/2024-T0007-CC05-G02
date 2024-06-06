import { useState } from "react";
import GraphContainer from "../../components/GraphContainer";
import Sidebar from "../../components/Sidebar";
import { Container } from "./style";
import UploadCSV from "../../components/CSVUpload";

function GraphViewer() {
  const [fileUploaded, setFileUploaded] = useState(false);
  const [fileSent, setFileSent] = useState(true);

  return (
    <Container>
      {fileSent ? (
        <>
          <Sidebar />
          <GraphContainer />
        </>
      ) : (
        <UploadCSV setFileSent={setFileSent} />
      )}
    </Container>
  );
}

export default GraphViewer;
