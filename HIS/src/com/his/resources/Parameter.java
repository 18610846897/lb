package com.his.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	各项目参数，若分数和年龄相关，则单独处理，此类分数默认0
 *  row: 
 *  	row0	结果否（0）
 *  	row1	结果是（1）
 *  	row2	结果无（2），如果没有无项，则没有第三行
 *  col: 
 *  	col0: 男
 *  	col1: 女
 *  ITEM1[1][1]表示：结果为是（1），女性（1）的分数，即0
 * @author lsy
 *
 */
public class Parameter {

	public static final int[][] ITEM0 = {{50,50},{0,0}};
	public static final int[][] ITEM1 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM2 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM3 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM4 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM5 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM6 = {{0,0},{55,55},{0,0}};
	public static final int[][] ITEM7 = {{0,0},{55,55},{0,0}};
	public static final int[][] ITEM8 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM9 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM10 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM11 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM12 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM13 = {{0,0},{80,75},{0,0}};
	public static final int[][] ITEM14 = {{0,0},{75,50},{0,0}};
	public static final int[][] ITEM15 = {{0,0},{60,40},{0,0}};
	public static final int[][] ITEM16 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM17 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM18 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM19 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM20 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM21 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM22 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM23 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM24 = {{0,0},{75,75},{0,0}};
	public static final int[][] ITEM25 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM26 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM27 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM28 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM29 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM30 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM31 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM32 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM33 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM34 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM35 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM36 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM37 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM38 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM39 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM40 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM41 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM42 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM43 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM44 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM45 = {{0,0},{75,75},{0,0}};
	public static final int[][] ITEM46 = {{0,0},{85,85},{0,0}};
	public static final int[][] ITEM47 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM48 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM49 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM50 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM51 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM52 = {{0,0},{40,40},{0,0}};
	public static final int[][] ITEM53 = {{0,0},{75,75},{0,0}};
	public static final int[][] ITEM54 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM55 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM56 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM57 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM58 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM59 = {{0,0},{75,75},{0,0}};
	public static final int[][] ITEM60 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM61 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM62 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM63 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM64 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM65 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM66 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM67 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM68 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM69 = {{0,0},{75,75},{0,0}};
	public static final int[][] ITEM70 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM71 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM72 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM73 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM74 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM75 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM76 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM77 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM78 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM79 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM80 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM81 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM82 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM83 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM84 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM85 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM86 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM87 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM88 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM89 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM90 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM91 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM92 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM93 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM94 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM95 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM96 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM97 = {{0,0},{40,40},{0,0}};
	public static final int[][] ITEM98 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM99 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM100 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM101 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM102 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM103 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM104 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM105 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM106 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM107 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM108 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM109 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM110 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM111 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM112 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM113 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM114 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM115 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM116 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM117 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM118 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM119 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM120 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM121 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM122 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM123 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM124 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM125 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM126 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM127 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM128 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM129 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM130 = {{0,0},{25,25},{0,0}};
	public static final int[][] ITEM131 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM132 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM133 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM134 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM135 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM136 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM137 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM138 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM139 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM140 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM141 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM142 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM143 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM144 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM145 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM146 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM147 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM148 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM149 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM150 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM151 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM152 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM153 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM154 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM155 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM156 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM157 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM158 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM159 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM160 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM161 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM162 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM163 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM164 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM165 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM166 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM167 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM168 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM169 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM170 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM171 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM172 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM173 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM174 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM175 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM176 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM177 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM178 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM179 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM180 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM181 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM182 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM183 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM184 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM185 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM186 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM187 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM188 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM189 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM190 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM191 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM192 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM193 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM194 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM195 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM196 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM197 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM198 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM199 = {{0,0},{15,15},{0,0}};
	public static final int[][] ITEM200 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM201 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM202 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM203 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM204 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM205 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM206 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM207 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM208 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM209 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM210 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM211 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM212 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM213 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM214 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM215 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM216 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM217 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM218 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM219 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM220 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM221 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM222 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM223 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM224 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM225 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM226 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM227 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM228 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM229 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM230 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM231 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM232 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM233 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM234 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM235 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM236 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM237 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM238 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM239 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM240 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM241 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM242 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM243 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM244 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM245 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM246 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM247 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM248 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM249 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM250 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM251 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM252 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM253 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM254 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM255 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM256 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM257 = {{0,0},{26,26},{0,0}};
	public static final int[][] ITEM258 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM259 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM260 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM261 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM262 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM263 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM264 = {{0,0},{30,10},{0,0}};
	public static final int[][] ITEM265 = {{0,0},{30,10},{0,0}};
	public static final int[][] ITEM266 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM267 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM268 = {{0,0},{26,26},{0,0}};
	public static final int[][] ITEM269 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM270 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM271 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM272 = {{0,0},{10,10},{0,0}};
	public static final int[][] ITEM273 = {{0,0},{50,50},{0,0}};
	public static final int[][] ITEM274 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM275 = {{0,0},{26,26},{0,0}};
	public static final int[][] ITEM276 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM277 = {{0,0},{30,90},{0,0}};
	public static final int[][] ITEM278 = {{0,0},{0,30},{0,0}};
	public static final int[][] ITEM279 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM280 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM281 = {{0,0},{80,0},{0,0}};
	public static final int[][] ITEM282 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM283 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM284 = {{0,0},{26,26},{0,0}};
	public static final int[][] ITEM285 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM286 = {{0,0},{30,80},{0,0}};
	public static final int[][] ITEM287 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM288 = {{0,0},{0,15},{0,0}};
	public static final int[][] ITEM289 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM290 = {{0,0},{30,0},{0,0}};
	public static final int[][] ITEM291 = {{0,0},{80,30},{0,0}};
	public static final int[][] ITEM292 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM293 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM294 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM295 = {{0,0},{26,26},{0,0}};
	public static final int[][] ITEM296 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM297 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM298 = {{0,0},{80,80},{0,0}};
	public static final int[][] ITEM299 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM300 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM301 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM302 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM303 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM304 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM305 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM306 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM307 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM308 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM309 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM310 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM311 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM312 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM313 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM314 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM315 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM316 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM317 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM318 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM319 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM320 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM321 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM322 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM323 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM324 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM325 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM326 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM327 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM328 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM329 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM330 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM331 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM332 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM333 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM334 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM335 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM336 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM337 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM338 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM339 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM340 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM341 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM342 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM343 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM344 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM345 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM346 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM347 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM348 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM349 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM350 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM351 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM352 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM353 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM354 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM355 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM356 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM357 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM358 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM359 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM360 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM361 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM362 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM363 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM364 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM365 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM366 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM367 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM368 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM369 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM370 = {{0,0},{60,60},{0,0}};
	public static final int[][] ITEM371 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM372 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM373 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM374 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM375 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM376 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM377 = {{0,0},{0,0},{0,0}};
	public static final int[][] ITEM378 = {{0,0},{30,30},{0,0}};
	public static final int[][] ITEM379 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM380 = {{0,0},{20,20},{0,0}};
	public static final int[][] ITEM381 = {{0,0},{90,90},{0,0}};
	public static final int[][] ITEM382 = {{0,0},{10,10},{0,0}};



	public final static List<int[][]> ITEM_LIST = new ArrayList<int[][]>(
			Arrays.asList(ITEM0,
					ITEM1,
					ITEM2,
					ITEM3,
					ITEM4,
					ITEM5,
					ITEM6,
					ITEM7,
					ITEM8,
					ITEM9,
					ITEM10,
					ITEM11,
					ITEM12,
					ITEM13,
					ITEM14,
					ITEM15,
					ITEM16,
					ITEM17,
					ITEM18,
					ITEM19,
					ITEM20,
					ITEM21,
					ITEM22,
					ITEM23,
					ITEM24,
					ITEM25,
					ITEM26,
					ITEM27,
					ITEM28,
					ITEM29,
					ITEM30,
					ITEM31,
					ITEM32,
					ITEM33,
					ITEM34,
					ITEM35,
					ITEM36,
					ITEM37,
					ITEM38,
					ITEM39,
					ITEM40,
					ITEM41,
					ITEM42,
					ITEM43,
					ITEM44,
					ITEM45,
					ITEM46,
					ITEM47,
					ITEM48,
					ITEM49,
					ITEM50,
					ITEM51,
					ITEM52,
					ITEM53,
					ITEM54,
					ITEM55,
					ITEM56,
					ITEM57,
					ITEM58,
					ITEM59,
					ITEM60,
					ITEM61,
					ITEM62,
					ITEM63,
					ITEM64,
					ITEM65,
					ITEM66,
					ITEM67,
					ITEM68,
					ITEM69,
					ITEM70,
					ITEM71,
					ITEM72,
					ITEM73,
					ITEM74,
					ITEM75,
					ITEM76,
					ITEM77,
					ITEM78,
					ITEM79,
					ITEM80,
					ITEM81,
					ITEM82,
					ITEM83,
					ITEM84,
					ITEM85,
					ITEM86,
					ITEM87,
					ITEM88,
					ITEM89,
					ITEM90,
					ITEM91,
					ITEM92,
					ITEM93,
					ITEM94,
					ITEM95,
					ITEM96,
					ITEM97,
					ITEM98,
					ITEM99,
					ITEM100,
					ITEM101,
					ITEM102,
					ITEM103,
					ITEM104,
					ITEM105,
					ITEM106,
					ITEM107,
					ITEM108,
					ITEM109,
					ITEM110,
					ITEM111,
					ITEM112,
					ITEM113,
					ITEM114,
					ITEM115,
					ITEM116,
					ITEM117,
					ITEM118,
					ITEM119,
					ITEM120,
					ITEM121,
					ITEM122,
					ITEM123,
					ITEM124,
					ITEM125,
					ITEM126,
					ITEM127,
					ITEM128,
					ITEM129,
					ITEM130,
					ITEM131,
					ITEM132,
					ITEM133,
					ITEM134,
					ITEM135,
					ITEM136,
					ITEM137,
					ITEM138,
					ITEM139,
					ITEM140,
					ITEM141,
					ITEM142,
					ITEM143,
					ITEM144,
					ITEM145,
					ITEM146,
					ITEM147,
					ITEM148,
					ITEM149,
					ITEM150,
					ITEM151,
					ITEM152,
					ITEM153,
					ITEM154,
					ITEM155,
					ITEM156,
					ITEM157,
					ITEM158,
					ITEM159,
					ITEM160,
					ITEM161,
					ITEM162,
					ITEM163,
					ITEM164,
					ITEM165,
					ITEM166,
					ITEM167,
					ITEM168,
					ITEM169,
					ITEM170,
					ITEM171,
					ITEM172,
					ITEM173,
					ITEM174,
					ITEM175,
					ITEM176,
					ITEM177,
					ITEM178,
					ITEM179,
					ITEM180,
					ITEM181,
					ITEM182,
					ITEM183,
					ITEM184,
					ITEM185,
					ITEM186,
					ITEM187,
					ITEM188,
					ITEM189,
					ITEM190,
					ITEM191,
					ITEM192,
					ITEM193,
					ITEM194,
					ITEM195,
					ITEM196,
					ITEM197,
					ITEM198,
					ITEM199,
					ITEM200,
					ITEM201,
					ITEM202,
					ITEM203,
					ITEM204,
					ITEM205,
					ITEM206,
					ITEM207,
					ITEM208,
					ITEM209,
					ITEM210,
					ITEM211,
					ITEM212,
					ITEM213,
					ITEM214,
					ITEM215,
					ITEM216,
					ITEM217,
					ITEM218,
					ITEM219,
					ITEM220,
					ITEM221,
					ITEM222,
					ITEM223,
					ITEM224,
					ITEM225,
					ITEM226,
					ITEM227,
					ITEM228,
					ITEM229,
					ITEM230,
					ITEM231,
					ITEM232,
					ITEM233,
					ITEM234,
					ITEM235,
					ITEM236,
					ITEM237,
					ITEM238,
					ITEM239,
					ITEM240,
					ITEM241,
					ITEM242,
					ITEM243,
					ITEM244,
					ITEM245,
					ITEM246,
					ITEM247,
					ITEM248,
					ITEM249,
					ITEM250,
					ITEM251,
					ITEM252,
					ITEM253,
					ITEM254,
					ITEM255,
					ITEM256,
					ITEM257,
					ITEM258,
					ITEM259,
					ITEM260,
					ITEM261,
					ITEM262,
					ITEM263,
					ITEM264,
					ITEM265,
					ITEM266,
					ITEM267,
					ITEM268,
					ITEM269,
					ITEM270,
					ITEM271,
					ITEM272,
					ITEM273,
					ITEM274,
					ITEM275,
					ITEM276,
					ITEM277,
					ITEM278,
					ITEM279,
					ITEM280,
					ITEM281,
					ITEM282,
					ITEM283,
					ITEM284,
					ITEM285,
					ITEM286,
					ITEM287,
					ITEM288,
					ITEM289,
					ITEM290,
					ITEM291,
					ITEM292,
					ITEM293,
					ITEM294,
					ITEM295,
					ITEM296,
					ITEM297,
					ITEM298,
					ITEM299,
					ITEM300,
					ITEM301,
					ITEM302,
					ITEM303,
					ITEM304,
					ITEM305,
					ITEM306,
					ITEM307,
					ITEM308,
					ITEM309,
					ITEM310,
					ITEM311,
					ITEM312,
					ITEM313,
					ITEM314,
					ITEM315,
					ITEM316,
					ITEM317,
					ITEM318,
					ITEM319,
					ITEM320,
					ITEM321,
					ITEM322,
					ITEM323,
					ITEM324,
					ITEM325,
					ITEM326,
					ITEM327,
					ITEM328,
					ITEM329,
					ITEM330,
					ITEM331,
					ITEM332,
					ITEM333,
					ITEM334,
					ITEM335,
					ITEM336,
					ITEM337,
					ITEM338,
					ITEM339,
					ITEM340,
					ITEM341,
					ITEM342,
					ITEM343,
					ITEM344,
					ITEM345,
					ITEM346,
					ITEM347,
					ITEM348,
					ITEM349,
					ITEM350,
					ITEM351,
					ITEM352,
					ITEM353,
					ITEM354,
					ITEM355,
					ITEM356,
					ITEM357,
					ITEM358,
					ITEM359,
					ITEM360,
					ITEM361,
					ITEM362,
					ITEM363,
					ITEM364,
					ITEM365,
					ITEM366,
					ITEM367,
					ITEM368,
					ITEM369,
					ITEM370,
					ITEM371,
					ITEM372,
					ITEM373,
					ITEM374,
					ITEM375,
					ITEM376,
					ITEM377,
					ITEM378,
					ITEM379,
					ITEM380,
					ITEM381,
					ITEM382
			));
	
}
