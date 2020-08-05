package com.study.sweetk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.sweetk.repository.mapper.HwPoiMapper;
import com.study.sweetk.repository.vo.HwPoiVo;
import com.study.sweetk.repository.vo.LatLngVo;

@Controller
public class GoogleMapController {
	
	@Autowired
	HwPoiMapper hwPoiMapper;

	@GetMapping("/poiList")
    @ResponseBody
    public HashMap<String, HashMap<LatLngVo, HwPoiVo>> getPoiList(String query){
		List<HwPoiVo> poiList = hwPoiMapper.selectPoiList();
		HashMap<String, HashMap<LatLngVo, HwPoiVo>> map = new HashMap<>();
		
		for(HwPoiVo tmpPoi : poiList) {
			if(map.get(tmpPoi.getLangCodeId()) == null) {
				map.put(tmpPoi.getLangCodeId(), new HashMap<LatLngVo, HwPoiVo>());
			}
			map.get(tmpPoi.getLangCodeId()).put(new LatLngVo(tmpPoi.getMapPositionY(), tmpPoi.getMapPositionX()), tmpPoi);
		}
		
       	return map;
    }
	
}
