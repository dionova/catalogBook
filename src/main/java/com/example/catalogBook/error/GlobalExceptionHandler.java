package com.example.catalogBook.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex, Model model) {
        logger.error("Произошла непредвиденная ошибка: ", ex);
        model.addAttribute("errorMessage", "Произошла непредвиденная ошибка. Пожалуйста, попробуйте позже.");
        return new ModelAndView("error/general_error", model.asMap());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundException(NoHandlerFoundException ex, Model model) {
        logger.error("Страница не найдена: ", ex);
        model.addAttribute("errorMessage", "Страница не найдена");
        return new ModelAndView("error/404", model.asMap());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex, Model model) {
        logger.error("Некорректный запрос: ", ex);
        model.addAttribute("errorMessage", "Некорректный запрос. Пожалуйста, проверьте введенные данные.");
        return new ModelAndView("error/400", model.asMap());
    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDatabaseException(DataAccessException ex, Model model) {
        logger.error("Ошибка базы данных: ", ex);
        model.addAttribute("errorMessage", "Ошибка базы данных. Пожалуйста, попробуйте позже.");
        return new ModelAndView("error/500", model.asMap());
    }
}
