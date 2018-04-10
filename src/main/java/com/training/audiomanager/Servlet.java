package com.training.audiomanager;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.command.HomePage;
import com.training.audiomanager.command.genre.AddGenre;
import com.training.audiomanager.command.genre.RemoveGenre;
import com.training.audiomanager.command.track.*;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackServiceImpl;
import com.training.audiomanager.service.PerformerServiceImpl;
import com.training.audiomanager.util.CommandConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/app/*")
public class Servlet extends HttpServlet {

    private Map<String, Command> commandMap;

    @Override
    public void init() throws ServletException {
        MusicTrackServiceImpl musicTrackServiceImpl = new MusicTrackServiceImpl();
        GenreService genreService = new GenreService();
        PerformerServiceImpl performerServiceImpl = new PerformerServiceImpl();
        commandMap = new HashMap<>();
        commandMap.put(CommandConstants.HOME_PAGE, new HomePage(musicTrackServiceImpl, genreService));
        commandMap.put(CommandConstants.ADD_TRACK_PAGE, new AddTrackPage(genreService, performerServiceImpl));
        commandMap.put(CommandConstants.ADD_TRACK, new AddTrack(musicTrackServiceImpl, genreService, performerServiceImpl));
        commandMap.put(CommandConstants.EDIT_TRACK_PAGE, new EditTrackPage(musicTrackServiceImpl, genreService, performerServiceImpl));
        commandMap.put(CommandConstants.EDIT_TRACK, new EditTrack(musicTrackServiceImpl, genreService, performerServiceImpl));
        commandMap.put(CommandConstants.REMOVE_TRACK, new RemoveTrack(musicTrackServiceImpl));
        commandMap.put(CommandConstants.GET_TRACKS_BY_GENRE, new GetTracksByGenre(musicTrackServiceImpl, genreService));
        commandMap.put(CommandConstants.GET_TRACKS_BY_DURATION, new GetTracksByDuration(musicTrackServiceImpl, genreService));
        commandMap.put(CommandConstants.GET_TRACKS_BY_PERFORMER, new GetTrackByPerformer(musicTrackServiceImpl, genreService));
        commandMap.put(CommandConstants.ADD_GENRE, new AddGenre(genreService));
        commandMap.put(CommandConstants.REMOVE_GENRE, new RemoveGenre(genreService));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().replaceAll(".*/app/", "");
        System.out.println("URL :" + url);
        Command command = commandMap.getOrDefault(url, commandMap.get(CommandConstants.HOME_PAGE));
        if (url.contains("redirect")) {
            resp.sendRedirect(command.execute(req));
        } else {
            req.getRequestDispatcher(command.execute(req)).forward(req, resp);
        }

    }
}
