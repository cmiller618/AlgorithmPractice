import { useRef, useState } from 'react';
import { Chessboard } from 'react-chessboard';
import React, { useContext, useEffect } from 'react';
import { updateMatch, addMatch } from '../services/MatchesAPI'
import { Link } from "react-router-dom"
import AuthContext from "../context/AuthContext";
import Chess from 'chess.js';

const socketUrl = "ws:localhost:8080/messages"
const ws = new WebSocket(socketUrl)

export default function BoardPvP({ boardWidth }) {
  const myColor = 'b';
  const auth = useContext(AuthContext);

  const chessboardRef = useRef();
  const [game, setGame] = useState(new Chess());
  const [match, setMatch] = useState({
    "matchId": "",
    "player1Id": auth.id,
    "player2Id": "",
    "playerWinnerId": "",
    "startTime": "00:00:00",
    "endTime": null
  });

  useEffect(() => {
    ws.onopen = () => {
      console.log("websocket successfully connected.")
      ws.send(JSON.stringify({
        id: auth.user.id,
        username: auth.user.username
      }))
    };

    ws.onmessage = function (message) {
      const dataFromServer = JSON.parse(message.data);
      console.log(dataFromServer);
      
      if(dataFromServer.type === "message"){
        setGame(new Chess(dataFromServer.fen));
        if(game.game_over()){
          console.log("game is over");
        }
      }

      if(dataFromServer.type === "userInfo"){
        const newMatch = {
          "matchId": 0,
          "player1Id": auth.id,
          "player2Id": dataFromServer.id,
          "playerWinnerId": "",
          "startTime": "00:00:00",
          "endTime": null
        }
        setMatch(addMatch(newMatch, auth));
      }
    };
  }, []);

  function onDrop(sourceSquare, targetSquare) {
    const gameCopy = { ...game };
    const move = gameCopy.move({
      from: sourceSquare,
      to: targetSquare,
      promotion: 'q' 
    });
    
    if(gameCopy.turn() === myColor){
      if(move){
        ws.send(JSON.stringify({
          type:"message",
          fen: game.fen(),
          match: match
        }))
      }

      if(game.game_over()){
        console.log("game is over");
      }

      setGame(gameCopy);
      return move;
    }else{
      return false;
    }
  }

  const EndGameButton = () => {
    ws.onclose = function () {
      console.log("websocket closed.")
    };
  }

  return (
    <div>
      <h2>You're White</h2>
      <Chessboard
        id="PlayVsPlay"
        animationDuration={200}
        boardWidth={boardWidth}
        position={game.fen()}
        onPieceDrop={onDrop}
        customBoardStyle={{
          borderRadius: '4px',
          boxShadow: '0 5px 15px rgba(0, 0, 0, 0.5)'
        }}
        ref={chessboardRef}
      />
      <Link to="/" onClick={EndGameButton} className="btn btn-warning" >End Game</Link>
    </div>
  );
}