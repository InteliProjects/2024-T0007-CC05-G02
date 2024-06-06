import React, { useState } from "react";

import { Container, FormContainer } from "./styles";

function CSVUpload({ setFileSent }) {
  const [file, setFile] = useState(null);

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!file) {
      alert("Por favor, selecione um arquivo CSV para fazer upload.");
      return;
    }
    const formData = new FormData();
    formData.append("file", file);

    try {
      // const response = await axios.post(
      //     "YOUR_BACKEND_ENDPOINT",
      //     formData,
      //     {
      //         headers: {
      //             "Content-Type": "multipart/form-data",
      //         },
      //     }
      // );
      alert("Upload do CSV concluído com sucesso!");
      setFileSent(true);
    } catch (error) {
      console.error("Erro no upload:", error);
      alert("Erro ao fazer upload do CSV.");
    }
  };

  return (
    <Container>
      <FormContainer>
        <form onSubmit={handleSubmit}>
          <h2>Upload de arquivo CSV</h2>
          <input type="file" accept=".csv" onChange={handleFileChange} />
          <button type="submit">Fazer upload</button>
        </form>
      </FormContainer>
    </Container>
  );
}

export default CSVUpload;
