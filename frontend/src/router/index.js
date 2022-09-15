import VueRouter from 'vue-router';
import loginBox from '../components/login_register/loginBox'
import registerBox from '../components//login_register/registerBox'
import mainPage from '../components/login_register/mainPage'
import classInfo from '../components/classinfo/classInfo'
import manager from '../components/TestPaper/manager'
import testPage from '../components/TestPaper/testPage'
import scorePage from '../components/TestPaper/scorePage'

export default new VueRouter({
    routes: [
        {
            path: '*',
            redirect: '/mainPage'
        },
        {
            path: '/mainPage',
            component: mainPage,
            redirect: '/mainPage/login',
            children: [
                {
                    path: 'login',
                    component: loginBox,
                    meta: {
                        title: '登录'
                    }
                },
                {
                    path: 'register',
                    component: registerBox,
                    meta: {
                        title: '注册'
                    }
                }
            ]
        },
        {
            path: '/classInfo',
            component: classInfo,
            meta: {
                title: '班级信息'
            }
        },
        {
            path: '/manager',
            component: manager,
            meta: {
                title: '考试管理'
            }
        },
        {
            path:'/testPage',
            component: testPage,
            meta:{
                title:'考试'
            }
        },
        {
            path:'/scorePage',
            component:scorePage,
            meta:{
                title:'成绩结算'
            }
        }



    ]
})