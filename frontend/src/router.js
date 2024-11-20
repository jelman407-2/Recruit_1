
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RecruitmngRecruitManager from "./components/listers/RecruitmngRecruitCards"
import RecruitmngRecruitDetail from "./components/listers/RecruitmngRecruitDetail"

import HrHrManager from "./components/listers/HrHrCards"
import HrHrDetail from "./components/listers/HrHrDetail"

import DepartmentDepartmentManager from "./components/listers/DepartmentDepartmentCards"
import DepartmentDepartmentDetail from "./components/listers/DepartmentDepartmentDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/recruitmngs/recruits',
                name: 'RecruitmngRecruitManager',
                component: RecruitmngRecruitManager
            },
            {
                path: '/recruitmngs/recruits/:id',
                name: 'RecruitmngRecruitDetail',
                component: RecruitmngRecruitDetail
            },

            {
                path: '/hrs/hrs',
                name: 'HrHrManager',
                component: HrHrManager
            },
            {
                path: '/hrs/hrs/:id',
                name: 'HrHrDetail',
                component: HrHrDetail
            },

            {
                path: '/departments/departments',
                name: 'DepartmentDepartmentManager',
                component: DepartmentDepartmentManager
            },
            {
                path: '/departments/departments/:id',
                name: 'DepartmentDepartmentDetail',
                component: DepartmentDepartmentDetail
            },




    ]
})
