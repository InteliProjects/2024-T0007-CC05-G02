import React from 'react';
import Modal from 'react-modal';
import styled from 'styled-components'

import "./styles.css"

const NodeModal = ({ isOpen, closeModal, nodeData }) => {
  return (
    <Modal isOpen={isOpen} onRequestClose={closeModal} overlayClassName="modal-overlay" className="modal-content">
      <Container>
        <p>Cliente: {nodeData && nodeData.cliente}</p>
        <StyledH1>Minério: {nodeData && nodeData.minerio}</StyledH1>
        <StyledH2> Quantidade: {nodeData && nodeData.quantidade}</StyledH2>
        < StyledButton onClick={closeModal} >Close</StyledButton>
      </Container>
    </Modal>
  );
};

export default NodeModal;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
`;

const StyledH1 = styled.h1`
  margin-top: 20px; 
`;

const StyledH2 = styled.h2`
  margin-top: 10px; 
`;

const StyledButton = styled.button`
  margin-top: 300px;
  margin-bottom:20px; 
  margin-left: 5px;
`;
