import styled from "styled-components";

import fulchs from "./assets/fulchs.png";
import farias from "./assets/farias.png";
import katsuki from "./assets/katsuki.png";
import mauri from "./assets/mauri.png";
import patrick from "./assets/patrick.png";
import tommy from "./assets/tommy.png";
import tomaz from "./assets/tomaz.png";
import github from "./assets/github.png";
import linkedin from "./assets/linkedin.png";

export default function AboutUs({ aboutUsRef, ourTeamRef }) {
    const teamInfo = [
        {
            name: "Felipe Fuchs",
            major: "Ciência da Computação",
            linkedin: "https://www.linkedin.com/in/eduardosbarreto/",
            github: "https://github.com/Eduardo-Barreto",
            photo: foto_edu,
        },
        {
            name: "Gabriel Farias",
            major: "Ciência da Computação",
            linkedin: "https://www.linkedin.com/in/gabriel-farias-alves/",
            github: "https://github.com/farias-77",
            photo: foto_farias,
        },
        {
            name: "Giovana Katsuki",
            major: "Ciência da Computação",
            linkedin:
                "https://www.linkedin.com/in/giovana-katsuki-murata-503a94264/",
            github: "https://github.com/katsukimurata",
            photo: foto_katsuki,
        },
        {
            name: "Maurício Azevedo",
            major: "Ciência da Computação",
            linkedin: "https://www.linkedin.com/in/isabelle-santos-507067204/",
            github: "https://github.com/Isabelleatt",
            photo: foto_isabelle,
        },
        {
            name: "Patrick Savoia",
            major: "Ciência da Computação",
            linkedin: "https://www.linkedin.com/in/lucas-nogueira-nunes/",
            github: "https://github.com/lucaoshow",
            photo: foto_lucas,
        },
        {
            name: "Tommy Goto",
            major: "Sistemas de Informações",
            linkedin: "https://www.linkedin.com/in/victor-gabriel-marques/",
            github: "https://github.com/VictorGM01",
            photo: foto_victor,
        },
        {
            name: "Tomaz Sasaki ",
            major: "Orientador",
            linkedin:
                "https://www.linkedin.com/in/marcelo-gonçalves-phd-a550652/",
            github: "https://github.com/GoncalvesMarcelo",
            photo: foto_marcelo,
        },
    ];

    return (
        <Container>
            <div ref={aboutUsRef}>
                <h1>Sobre Nós</h1>
                <p>
                    texto sobre nós 
                </p>
            </div>
            <div ref={ourTeamRef}>
                <h1>Nossa Equipe</h1>
                <TeamCardsHolder>
                    {teamInfo.map((member, index) => {
                        return (
                            <TeamCard key={index}>
                                <img src={member.photo} alt={member.name} />
                                <div>
                                    <h1>{member.name}</h1>
                                    <h2>{member.major}</h2>
                                    <Icons>
                                        <a
                                            href={member.linkedin}
                                            target="_blank"
                                            rel="noopener noreferrer"
                                        >
                                            <img
                                                src={linkedin}
                                                alt="linkedin"
                                            />
                                        </a>
                                        <a
                                            href={member.github}
                                            target="_blank"
                                            rel="noopener noreferrer"
                                        >
                                            <img src={github} alt="github" />
                                        </a>
                                    </Icons>
                                </div>
                            </TeamCard>
                        );
                    })}
                </TeamCardsHolder>
            </div>
        </Container>
    );
}

const Container = styled.div`
    width: 100%;
    min-height: 70vh;

    padding-top: 100px;
    padding-bottom: 40px;

    display: flex;
    flex-direction: column;
    align-items: center;

    h1 {
        color: #30947c;
        text-align: center;
        font-size: 64px;
        font-style: normal;
        font-weight: 500;
    }

    p {
        margin: 0 20%;
        margin-top: 70px;
        margin-bottom: 100px;

        color: #000;
        text-align: center;
        font-size: 20px;
        font-style: normal;
        font-weight: 400;
        line-height: 140.625%;
    }
`;

const TeamCardsHolder = styled.div`
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 16px;

    padding: 0 10%;

    margin-top: 50px;
`;

const TeamCard = styled.div`
    width: 260px;
    height: 400px;

    border-radius: 20px;

    img {
        width: 100%;
        height: 70%;
        object-fit: cover;
        border-radius: 20px 20px 0 0;
    }

    > div {
        width: 100%;
        height: 30%;

        padding: 5px 5px;

        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: space-evenly;

        border-radius: 0 0 20px 20px;

        background-color: #f2f2f2;
    }

    h1 {
        font-size: 20px;
        font-style: normal;
        font-weight: 500;
        line-height: normal;
        color: #000;
    }

    h2 {
        color: #000;
        font-size: 14px;
        font-style: normal;
        font-weight: 300;
        line-height: normal;
    }
`;

const Icons = styled.div`
    width: 100%;
    display: flex;
    justify-content: flex-end;

    img {
        width: 30px;
        height: 30px;

        border-radius: 0;
        margin: 0 10px;

        cursor: pointer;

        &:hover {
            filter: brightness(1.2);
        }
    }
`;