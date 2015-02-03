package org.isen.jee.exam.bowling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BowlingScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = getGame(req);
        resp.getWriter().print(String.format("%d", game.getScore()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pinsParam = req.getParameter("pins");
        if(pinsParam == null) {
            resp.sendError(400, "Pins param cannot be null");

        }

        Game game = getGame(req);
        int pins = Integer.parseInt(pinsParam);
        if(pins <0 || pins > 10) {
            resp.sendError(400, "Pins must be between 0 and 10");
        }
        game.hit(pins);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("game");
    }

    private Game getGame(HttpServletRequest req) {
        Object game = req.getSession().getAttribute("game");
        if(game == null) {
            game = new GameImpl();
            req.getSession().setAttribute("game",game);
        }
        return (Game) game;
    }
}
