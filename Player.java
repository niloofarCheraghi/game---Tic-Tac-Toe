package Game;

import Game.Util.BoardLineTypeEnum;
import Game.Util.PlayerTypeEnum;

public class Player {
    private PlayerTypeEnum _turn;

    public Player(PlayerTypeEnum firstPlayer) {
        _turn = firstPlayer;
    }

    public PlayerTypeEnum GetTurn() {
        return _turn;
    }

    public void SetTurn(PlayerTypeEnum type) {
        _turn = type;
    }

    public void ChangePlayer() {
        if (_turn.equals(PlayerTypeEnum.X)) {
            _turn = PlayerTypeEnum.O;
        } else {
            _turn = PlayerTypeEnum.X;
        }
    }

    public PlayerTypeEnum GetWinner(BoardLineTypeEnum lineTyoe) {
        if (lineTyoe.equals(BoardLineTypeEnum.XXX))
            return PlayerTypeEnum.X;
        if (lineTyoe.equals(BoardLineTypeEnum.OOO))
            return PlayerTypeEnum.O;
        return PlayerTypeEnum.Invalid;
    }
}
