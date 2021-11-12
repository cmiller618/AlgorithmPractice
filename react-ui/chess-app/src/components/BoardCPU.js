import { useRef, useState } from 'react';
import Chess from 'chess.js';
import { Link } from 'react-router-dom';
import "./Board.css"

import { Chessboard } from 'react-chessboard';

export default function BoardCPU({ boardWidth }) {
  const chessboardRef = useRef();
  const [game, setGame] = useState(new Chess());
  const [arrows, setArrows] = useState([]);
  const [boardOrientation, setBoardOrientation] = useState('white');

  function safeGameMutate(modify) {
    setGame((g) => {
      const update = { ...g };
      modify(update);
      return update;
    });
  }

  function makeRandomMove() {
    const possibleMoves = game.moves();

    // exit if the game is over
    if (game.game_over() || game.in_draw() || possibleMoves.length === 0) return;

    const randomIndex = Math.floor(Math.random() * possibleMoves.length);
    safeGameMutate((game) => {
      game.move(possibleMoves[randomIndex]);
    });
  }

  function onDrop(sourceSquare, targetSquare) {
    const gameCopy = { ...game };
    const move = gameCopy.move({
      from: sourceSquare,
      to: targetSquare,
      promotion: 'q' // always promote to a queen for example simplicity
    });
    setGame(gameCopy);

    // illegal move
    if (move === null) return false;

    setTimeout(makeRandomMove, 200);
    return true;
  }

  return (
    <div className="card text-center">
      {game.gameOver ? <h3>Game Over</h3> :
        <div id="whiteBoard" className="card-body">
        <div className="row">
        <div id="container">
      <Chessboard
        id="PlayVsRandom"
        arePremovesAllowed={true}
        animationDuration={200}
        boardOrientation={boardOrientation}
        boardWidth={boardWidth}
        customArrows={arrows}
        position={game.fen()}
        onPieceDrop={onDrop}
        customBoardStyle={{
          borderRadius: '4px',
          boxShadow: '0 5px 15px rgba(0, 0, 0, 0.5)'
        }}
        ref={chessboardRef}
      />
      <button
        className="btn btn-warning"
        onClick={() => {
          safeGameMutate((game) => {
            game.reset();
          });
          chessboardRef.current.clearPremoves();
        }}
      >
        reset
      </button>
      <button
        className="btn btn-warning"
        onClick={() => {
          setBoardOrientation((currentOrientation) => (currentOrientation === 'white' ? 'black' : 'white'));
        }}
      >
        flip board
      </button>
      <button
        className="btn btn-warning"
        onClick={() => {
          safeGameMutate((game) => {
            game.undo();
          });
          chessboardRef.current.clearPremoves();
        }}
      >
        undo
      </button>
      <button
        className="btn btn-warning"
        onClick={() => {
          setArrows([
            ['a3', 'a5'],
            ['g1', 'f3']
          ]);
        }}
      >
        Set Custom Arrows
      </button>
      <Link to="/" className="btn btn-warning" >End Game</Link>
    </div>
    </div>
    </div>
    }
</div>
  
  );
}
