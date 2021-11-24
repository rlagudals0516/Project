package kr.co.tjoeun.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.model.entity.CsDao;
import kr.co.tjoeun.model.entity.CsVo;

@Controller
public class CsController {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	CsDao csDao;
	
	@GetMapping("/cs")
	public String csList(Model model) throws SQLException {
		log.info("csList run...");
		model.addAttribute("list", csDao.selectAll());
		return "csList";
	}
	
	@GetMapping("/cs/detail")
	public String csDetail(Model model, @RequestParam int csno) throws SQLException {
		log.info("csDetail run...");
		model.addAttribute("detail", csDao.selectOne(csno));
		return "csDetail";
	}
	
	@GetMapping("/cs/update")
	public String csUpdate(Model model, @RequestParam int csno) throws SQLException {
		log.info("csUpdate run...");
		model.addAttribute("detail", csDao.selectOne(csno));
		return "csUpdate";
	}
	
	@GetMapping("/cs/update_action")
	public String csUpdateAction(Model model, HttpServletRequest httpServletRequest, @RequestParam int csno) throws SQLException {
		log.info("csUpdateAction run...");
		String cssub = httpServletRequest.getParameter("cssub");
		String cscontent = httpServletRequest.getParameter("cscontent");
		model.addAttribute("update", csDao.updateOne(csno, cssub, cscontent));
		return "redirect:/cs";
	}
	
	@GetMapping("/cs/delete")
	public String csDelete(Model model, @RequestParam int csno) throws SQLException {
		log.info("csDelete run...");
		model.addAttribute("delete", csDao.deleteOne(csno));
		return "redirect:/cs";
	}
	
	@GetMapping("/cs/insert")
	public String csInsert() {
		return "csInsert";
	}
	
	@PostMapping("/cs/insert_action")
	public String csEdit(CsVo bean) throws SQLException {
		log.info("csInsert run...");
		csDao.insertOne(bean);
		return "redirect:/cs/";
	}
}
