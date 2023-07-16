package org.luopanbi.web;


import org.luopanbi.business.datasource.DatasourceBizService;
import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.common.web.R;
import org.luopanbi.web.vo.AddDatasourceReq;
import org.luopanbi.web.vo.DatasourceVO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/datasource/v1")
public class DatasourceController {

    private DatasourceBizService datasourceBizService;

    public DatasourceController(DatasourceBizService datasourceBizService) {
        this.datasourceBizService = datasourceBizService;
    }

    @GetMapping("/list")
    public R<PageResult<DatasourceVO>> listAll(PageParam pageParam) {
        PageResult<DatasourceVO> result = datasourceBizService.listAll(pageParam);
        return R.ok(result);
    }

    @PutMapping("/")
    public R<DatasourceVO> addDatasource(@Valid @RequestBody AddDatasourceReq addDatasourceReq) {
        DatasourceVO datasourceVO = datasourceBizService.addDatasource(addDatasourceReq, UUID.randomUUID().toString());
        return R.ok(datasourceVO);
    }


}
