package org.luopanbi.web;

import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.common.web.R;
import org.luopanbi.web.vo.AddDatasetReq;
import org.luopanbi.web.vo.DatasetVO;
import org.luopanbi.web.vo.EditDatasetReq;
import org.luopanbi.web.vo.EditDatasourceReq;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/dataset/v1")
public class DatasetController {

    @GetMapping("/list")
    public R<PageResult<DatasetVO>> listAll(PageParam pageParam) {

        return null;
    }

    @GetMapping("/{id}")
    public R<DatasetVO> getById(@PathVariable("id") Integer id) {
        return null;
    }

    @PutMapping("/")
    public R<DatasetVO> addDataset(@Valid @RequestBody AddDatasetReq addDatasetReq) {
        return null;
    }

    @PostMapping("/{id}")
    public R<DatasetVO> editDataset(@Valid @RequestBody EditDatasetReq editDatasetReq) {
        return null;
    }


}
