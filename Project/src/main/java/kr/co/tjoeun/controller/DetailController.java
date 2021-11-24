package kr.co.tjoeun.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.model.entity.DetailDao;
import kr.co.tjoeun.model.entity.DetailVo;

@Controller
public class DetailController {
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	DetailDao detailDao;

	@GetMapping("/detail")
	public String detail(Model model) throws IOException, SQLException {
		model.addAttribute("detailList", detailDao.selectAll());
		return "detail";
	}
	
	@PostMapping("/detail/insert")
	public String detailInsert(DetailVo bean) throws SQLException {
		log.info("detailInsert run...");	
		detailDao.insertOne(bean);
		return "redirect:/detail";
	}
	
	@GetMapping("/detail/update")
	public String detailUpdate(Model model, @RequestParam int detailno) throws SQLException {
		model.addAttribute("detailOne", detailDao.selectOne(detailno));
		model.addAttribute("detailList", detailDao.selectAll());
		return "detailUpdate";
	}
	
	@PostMapping("/detail/update_action")
	public String detailUpdateAction(DetailVo bean) throws SQLException {
		log.info("update run...");
		detailDao.updateOne(bean);
		return "redirect:/detail";
	}
	
	@PostMapping("/detail/delete")
	public String detailDelete(int detailno) throws SQLException {
		detailDao.deleteOne(detailno);
		return "redirect:/detail";
	}
}
